cd $(dirname $0)
SRC_DIR=.
DST_DIR=../src/main/java
/home/illay/Downloads/protoc-3.17.3-linux-x86_64/bin/protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/resumedto.proto