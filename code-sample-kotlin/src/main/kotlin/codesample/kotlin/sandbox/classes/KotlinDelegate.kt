package codesample.kotlin.sandbox.classes

interface VeryUsefullFunction {
    fun printInputWithGreeting(input: String)
}

class VeryUsefullFunctionImpl : VeryUsefullFunction {
    override fun printInputWithGreeting(input: String) {
        println("Hello, $input!")
    }
}

/** DelegatorForVeryUsefullFunction class can now use functions and properties defined in VeryUsefullFunction,
 * if an instance VeryUsefullFunction is passed in. See an example */
class DelegatorForVeryUsefullFunction(base: VeryUsefullFunction)
    : VeryUsefullFunction by base {
}

fun main(args: Array<String>) {
    val funcClass = VeryUsefullFunctionImpl()
    DelegatorForVeryUsefullFunction(funcClass).printInputWithGreeting("Ivan")
}