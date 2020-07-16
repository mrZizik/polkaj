package io.emeraldpay.polkaj.scale.reader

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import org.apache.commons.codec.binary.Hex
import spock.lang.Specification

import java.nio.charset.StandardCharsets

class StringReaderSpec extends Specification {

    StringReader reader = ScaleCodecReader.STRING

    def "Read"() {
        when:
        def codec = new ScaleCodecReader(Hex.decodeHex( hex))
        def act = codec.read(reader)
        then:
        act == value
        where:
        hex    | value
        "3048656c6c6f20576f726c6421" | "Hello World!"
        "1c" + Hex.encodeHexString("asdadad".getBytes(StandardCharsets.UTF_8)) | "asdadad"
    }
}
