package io.emeraldpay.polkaj.scale.writer

import io.emeraldpay.polkaj.scale.ScaleCodecWriter
import org.apache.commons.codec.binary.Hex
import spock.lang.Specification

import java.nio.charset.StandardCharsets

class StringWriterSpec extends Specification {

    def "Write string"() {
        expect:
        ByteArrayOutputStream buf = new ByteArrayOutputStream()
        new ScaleCodecWriter(buf).writeString(value)
        Hex.encodeHexString(buf.toByteArray()) == encoded
        where:
        encoded                                                                | value
        "1c" + Hex.encodeHexString("asdadad".getBytes(StandardCharsets.UTF_8)) | "asdadad"
    }
}
