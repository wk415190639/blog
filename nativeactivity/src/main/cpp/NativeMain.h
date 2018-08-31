
#ifndef _ANDROID_NATIVE_MAIN_H_
#define _ANDROID_NATIVE_MAIN_H_

#include <android/native_activity.h>


void bindLifeCycle(ANativeActivity *activity);


void ANativeActivity_onCreate(ANativeActivity *activity, void *savedState, size_t savedStateSize);


void *looper(void *args);

void onStart(ANativeActivity *activity);


void onResume(ANativeActivity *activity);


void *onSaveInstanceState(ANativeActivity *activity, size_t *outSize);


void onPause(ANativeActivity *activity);

void onStop(ANativeActivity *activity);


void onDestroy(ANativeActivity *activity);

void onWindowFocusChanged(ANativeActivity *activity, int hasFocus);


void onNativeWindowCreated(ANativeActivity *activity, ANativeWindow *window);


void onNativeWindowDestroyed(ANativeActivity *activity, ANativeWindow *window);

void onInputQueueCreated(ANativeActivity *activity, AInputQueue *queue);

void onInputQueueDestroyed(ANativeActivity *activity, AInputQueue *queue);


void onConfigurationChanged(ANativeActivity *activity);

void onLowMemory(ANativeActivity *activity);

#endif //_ANDROID_NATIVE_MAIN_H_