package io.emeraldpay.polkaj.scale.reader

import io.emeraldpay.polkaj.scale.ScaleCodecReader
import org.apache.commons.codec.binary.Hex
import spock.lang.Specification

class ShortReaderSpec extends Specification {

    ShortReader reader = new ShortReader()

    def "Read positive"() {
        expect:
        def codec = new ScaleCodecReader(Hex.decodeHex(hex))
        codec.read(reader) == value
        where:
        hex   | value
        "ff7f"| 32767
        "3930"| 12345
    }

    def "Read negative"() {
        expect:
        def codec = new ScaleCodecReader(Hex.decodeHex(hex))
        codec.read(reader) == value
        where:
        hex    | value
        "0180" | -32767
        "0080" | -32768
        "ffff" | -1
        "c7cf" | -12345
    }

}
