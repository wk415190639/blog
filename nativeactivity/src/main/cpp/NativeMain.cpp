
#include <pthread.h>

#include "NativeMain.h"


static bool isLoop = false;
static pthread_t loopID;

void onStart(ANativeActivity *activity) {
}

void onResume(ANativeActivity *activity) {

}

void *onSaveInstanceState(ANativeActivity *activity, size_t *outSize) {

    return nullptr;
}

void onPause(ANativeActivity *activity) {
}

void onStop(ANativeActivity *activity) {

}

void onDestroy(ANativeActivity *activity) {

}

void onWindowFocusChanged(ANativeActivity *activity, int hasFocus) {

}

void onNativeWindowCreated(ANativeActivity *activity, ANativeWindow *window) {

}

void onNativeWindowDestroyed(ANativeActivity *activity, ANativeWindow *window) {

}

void onInputQueueCreated(ANativeActivity *activity, AInputQueue *queue) {
    isLoop = true;
    activity->instance = (void *) queue;
    pthread_create(&loopID, NULL, looper, activity);
}

void onInputQueueDestroyed(ANativeActivity *activity, AInputQueue *queue) {
    isLoop = false;
}

void onConfigurationChanged(ANativeActivity *activity) {

}

void onLowMemory(ANativeActivity *activity) {

}

void bindLifeCycle(ANativeActivity *activity) {
    activity->callbacks->onStart = onStart;
    activity->callbacks->onResume = onResume;
    activity->callbacks->onSaveInstanceState = onSaveInstanceState;
    activity->callbacks->onPause = onPause;
    activity->callbacks->onStop = onStop;
    activity->callbacks->onDestroy = onDestroy;
    activity->callbacks->onWindowFocusChanged = onWindowFocusChanged;
    activity->callbacks->onNativeWindowCreated = onNativeWindowCreated;
    activity->callbacks->onNativeWindowDestroyed = onNativeWindowDestroyed;
    activity->callbacks->onInputQueueCreated = onInputQueueCreated;
    activity->callbacks->onInputQueueDestroyed = onInputQueueDestroyed;
    activity->callbacks->onConfigurationChanged = onConfigurationChanged;
    activity->callbacks->onLowMemory = onLowMemory;
}

void *looper(void *args) {
    ANativeActivity *activity = (ANativeActivity *) args;
    AInputQueue *queue = (AInputQueue *) activity->instance;
    AInputEvent *event = NULL;
    while (isLoop) {
        if (!AInputQueue_hasEvents(queue)) {
            continue;
        }
        AInputQueue_getEvent(queue, &event);
        float mx = AMotionEvent_getX(event, 0);
        float my = AMotionEvent_getY(event, 0);
        switch (AInputEvent_getType(event)) {
            case AINPUT_EVENT_TYPE_MOTION: {
                switch (AMotionEvent_getAction(event)) {
                    case AMOTION_EVENT_ACTION_DOWN: {
                        break;
                    }
                    case AMOTION_EVENT_ACTION_UP: {
                        break;
                    }
                    default:
                        break;
                }
                break;
            }
            case AINPUT_EVENT_TYPE_KEY: {
                switch (AKeyEvent_getAction(event)) {
                    case AKEY_EVENT_ACTION_DOWN: {
                        switch (AKeyEvent_getKeyCode(event)) {
                            case AKEYCODE_BACK: {
                                ANativeActivity_finish(activity);
                                break;
                            }
                            default:
                                break;
                        }
                        break;
                    }
                    case AKEY_EVENT_ACTION_UP: {
                        break;
                    }
                    default:
                        break;
                }
            }
            default:
                break;
        }
        AInputQueue_finishEvent(queue, event, 1);
    }
    return args;
}

void ANativeActivity_onCreate(ANativeActivity *activity, void *savedState, size_t savedStateSize) {
    bindLifeCycle(activity);
}