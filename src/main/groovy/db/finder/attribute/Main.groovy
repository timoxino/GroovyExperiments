package db.finder.attribute

import java.util.concurrent.Callable
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors

@Grab('com.oracle:ojdbc7:12.1.0.2')
@GrabConfig(systemClassLoader = true)

def amount = 50
def step = 10
def many = 5

def pool = Executors.newFixedThreadPool(many)
def attributesMap = new ConcurrentHashMap()
def futureList = []

many.times { time ->
    futureList.add(pool.submit(new Callable() {
        @Override
        Object call() throws Exception
        {
            def offset = time * amount
            Runner.run(new Setting(offset, step, amount), new File("execution$time"+'.log'), attributesMap)
        }
    }))
}

futureList.each { future ->
    future.get()
}

Reporter.report(50, attributesMap)
pool.shutdown()
