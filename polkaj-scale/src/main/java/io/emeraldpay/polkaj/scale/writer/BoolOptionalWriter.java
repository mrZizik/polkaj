package io.emeraldpay.polkaj.scale.writer;

import io.emeraldpay.polkaj.scale.ScaleWriter;
import io.emeraldpay.polkaj.scale.ScaleCodecWriter;

import java.io.IOException;
import java.util.Optional;

public class BoolOptionalWriter implements ScaleWriter<Optional<Boolean>> {

    @Override
    public void write(ScaleCodecWriter wrt, Optional<Boolean> value) throws IOException {
        if (value.isPresent()) {
            if (value.get()) {
                wrt.directWrite(2);
            } else {
                wrt.directWrite(1);
            }
        } else {
            wrt.directWrite(0);
        }
    }
}
