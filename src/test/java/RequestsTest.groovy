import spock.lang.Specification
import spritecn.github.bytool.Requests

class RequestsTest extends Specification {


    def "test requests"() {
        expect:
        def header = ["user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.41",
                      "sec-ch-ua-platform": "macOS",
                      "accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
                      "accept-encoding":"gzip, deflate"
        ]
        def response = Requests.get("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=111").headers(header).send()

    }

    def "test requestsSession"() {
        expect:
        def headers = ["user-agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.41",
                      "sec-ch-ua-platform": "macOS",
                      "accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
                      "accept-encoding":"gzip, deflate"
        ]
        def req = Requests.buildSessionRequestWithHeader(headers);
        def response = req.get("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=111").send()
        def response2 = req.get("https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=222震").send()
        println(response2.readToText())

    }

}


