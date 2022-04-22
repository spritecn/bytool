import spock.lang.Shared
import spock.lang.Specification
import spritecn.github.bytool.ArgsUtil

class ArgsUtilTest extends Specification {
    @Shared
    AClz testClassForNull = null
    AClz testClassFroNotNull = new AClz()


    def "test anyNull"() {
        expect:
            ArgsUtil.anyNull("a",1,null,testClassForNull)
        and:
            !ArgsUtil.anyNull("a",1,testClassFroNotNull)
        and:
            ArgsUtil.anyNull(testClassForNull)

    }

}

class AClz{}

