package ftp

class Logger
{
    private def static traceLog = new File('trace.log')
    private def static errorLog = new File('error.log')

    def static all(String message)
    {
        log(message, traceLog)
        log(message, errorLog)
    }

    def static trace(String message)
    {
        log(message, traceLog)
    }

    def static error(String message)
    {
        log(message, errorLog)
    }

    private static def log(String message, file)
    {
        file.append(format(message));
    }

    private static def format(String message)
    {
        '' + new Date() + " | $message \n"
    }
}
