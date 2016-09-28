@Grab(group = 'org.apache.activemq', module = 'activemq-all', version = '5.9.0')
import org.apache.activemq.ActiveMQConnectionFactory
@Grab(group = 'net.sf.gtools.jms', module = 'JmsCategory', version = '0.2')
import net.sf.gtools.jms.JmsCategory

def sendJMSMessage()
{
    use(JmsCategory) {

//        def jms = new ActiveMQConnectionFactory('failover:(tcp://adcmqq3.hiw.com:61616,tcp://adcmqq4.hiw.com:61616)?randomize=false')
        def jms = new ActiveMQConnectionFactory('failover:(tcp://va1ihgdhlt28.ihgext.global:61616)?randomize=true&timeout=30000&maxReconnectAttempts=4')
        jms.connect { c ->
//            c.topic("JMS/HCS.NOTIF.PUB.TOPIC") { q ->
            c.topic("JMS/HCM.NOTIF.TOPIC") { q ->

                q.listen { msg ->
                    println "received message: $msg"
                }
                // endless loop
                while (true)
                {
                    Thread.sleep(3000)
                    println 'alive'
                }

//                def msg = createTextMessage("gst-test")
//                q.send(msg)
            }

        }
    }
}

sendJMSMessage()
