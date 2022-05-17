import groovy.util.logging.Slf4j
import spock.lang.Specification
import spritecn.github.bytool.JSON



class JsonTest extends Specification {
    def "testJson"(){
        when:
        println  JSON.toJSONString(new TestClzzzz())
        then:
        noExceptionThrown();
    }

}

class TestClzzzz{
    public void getCaa(){
        println("caaa")
    }
}


