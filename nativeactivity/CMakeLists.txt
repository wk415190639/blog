

cmake_minimum_required(VERSION 3.4.1)
      
add_library( native-main SHARED
                 src/main/cpp/NativeMain.cpp  
                 )  
      
find_library( log-lib log )
MESSAGE( "lib": ${log-lib})

find_library( input-lib android )
MESSAGE( "lib": ${input-lib})


target_link_libraries( native-main ${log-lib} ${input-lib})