#include <jni.h>
#include <string>
#include "pthread.h"
#include <unistd.h>

extern "C" {
static JavaVM *javaVM;
jobject object;

JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved) {
    javaVM = vm;
    return JNI_VERSION_1_6;
}


void *callBackFn(void *arg) {


    int tag = 0;
    while (true) {

        JNIEnv *jniEnv;
        int res = javaVM->GetEnv((void **) &jniEnv, JNI_VERSION_1_6);

        if (res < JNI_OK) {

            int res = javaVM->AttachCurrentThread(&jniEnv, nullptr);

            if (res != JNI_OK) {

                break;
            }
        }

        jclass jclass1 = jniEnv->GetObjectClass(object);
        jmethodID jmethodID1 = jniEnv->GetMethodID(jclass1, "onCallBack", "(Ljava/lang/String;)V");

        int i = 0;
        char c[1];
        sprintf(c, "%d", tag++);

        jstring jtag = jniEnv->NewStringUTF(c);
        jniEnv->CallVoidMethod(object, jmethodID1, jtag);

        jniEnv->DeleteLocalRef(jtag);
        jniEnv->DeleteLocalRef(jclass1);

        sleep(1);

    }

    javaVM->DetachCurrentThread();

    return NULL;

}


JNIEXPORT void
JNICALL
Java_com_example_test_multithread_MainActivity_startCallBack(
        JNIEnv *env,
        jobject /* this */, jobject mainActivity) {

    object = env->NewGlobalRef(mainActivity);

    pthread_t t;
    pthread_create(&t, NULL, callBackFn, NULL);

}


}