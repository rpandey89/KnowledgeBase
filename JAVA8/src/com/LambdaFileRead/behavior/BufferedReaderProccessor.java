package com.LambdaFileRead.behavior;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by rahul.pandey on 4/18/17.
 */
@FunctionalInterface
public interface BufferedReaderProccessor {
    String process(BufferedReader br) throws IOException;
}
