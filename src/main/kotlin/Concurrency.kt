import kotlinx.coroutines.*

class Concurrency {
	fun run() {
		println("Run: ${Thread.currentThread()}")
	}

	suspend fun runSuspend() {
		println("Run suspend: ${Thread.currentThread()}")
	}
}

fun main(args: Array<String>) {
	val concurrency = Concurrency()

	println("${Thread.currentThread()}")
	println("${GlobalScope.coroutineContext}")

	concurrency.run()

	GlobalScope.launch {
		withContext(Dispatchers.Main) {
			concurrency.run()
		}
	}

	runBlocking {
		concurrency.runSuspend()
	}

	runBlocking {
		concurrency.runSuspend()
	}

	GlobalScope.launch {
		concurrency.runSuspend()
	}
}
