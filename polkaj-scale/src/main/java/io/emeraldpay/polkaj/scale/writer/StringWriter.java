package io.emeraldpay.polkaj.scale.writer;

import java.io.IOException;

import io.emeraldpay.polkaj.scale.ScaleCodecReader;
import io.emeraldpay.polkaj.scale.ScaleCodecWriter;
import io.emeraldpay.polkaj.scale.ScaleReader;
import io.emeraldpay.polkaj.scale.ScaleWriter;

/**
 * Read string, encoded as UTF-8 bytes
 */
public class StringWriter implements ScaleWriter<String> {

    @Override
    public void write(ScaleCodecWriter wrt, String value) throws IOException {
        wrt.writeString(value);
    }
}
