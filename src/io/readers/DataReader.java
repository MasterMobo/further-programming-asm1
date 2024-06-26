package io.readers;

/**
 * @author <Bui Dang Khoa - s3978482>
 */

public interface DataReader {
    // Reads data from anywhere and return it as string
    // Since only Strings are returned, please use a TypeConverter to convert to different types.
    String read();
}
