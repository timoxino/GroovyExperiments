@Grab(group = 'org.apache.activemq', module = 'activemq-all', version = '5.9.0')
import org.apache.activemq.ActiveMQConnectionFactory
@Grab(group = 'net.sf.gtools.jms', module = 'JmsCategory', version = '0.2')
import net.sf.gtools.jms.JmsCategory

System.setProperty("socksProxyHost", "localhost")
System.setProperty("socksProxyPort", "8888")
listen()

def listen()
{
    use(JmsCategory) {

        def jms = new ActiveMQConnectionFactory('failover:(tcp://iadd1plaqsmq001.ihgint.global:61616,tcp://iadd1plaqsmq002.ihgint.global:61616)?randomize=false')
        jms.connect { connection ->
            connection.topic("JMS/HCS.NOTIF.PUB.TOPIC") { topic ->

                topic.listen { msg ->
                    println "received message: $msg"
                }

                while (true)
                {
                    Thread.sleep(3000)
                    println 'alive'
                }
            }

        }
    }
}
