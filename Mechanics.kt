class Mechanics {
    private val alphabets = ('a'..'z') + ('a'..'z')
    private val alphabets2 = ('a'..'z') + ('a'..'z')
    private val list: MutableList<Char> = mutableListOf()
    private var unicod = (("!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ ") +
            ("!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~ ")).toList()

    private fun encryption(input: String, step: Int, output: String){
        for (i in input.indices) {
            var check = 0
            for (j in 0..96) {
                if (input[i] == unicod[j]) {
                    list.add(unicod[j + step])
                    break
                } else {
                    check++
                }
            }
            when(check) { 97 -> list.add(input[i]) }
        }
        if (output != "") {
            File(output).printWriter().use { out ->
                list.forEach { out.print(it)
                }
            }
        } else {
            list.forEach { print(it) }
        }
    }

    private fun decryption(input: String, step: Int, output: String){
        for (i in input.indices) {
            var check = 0
            for (j in 98..195) {
                if (input[i] == unicod[j]) {
                    list.add(unicod[j - step])
                    break
                } else {
                    check++
                }
            }
            when(check) { 97 -> list.add(input[i]) }
        }
        if (output != "") {
            File(output).printWriter().use { out ->
                list.forEach { out.print(it)
                }
            }
        } else {
            list.forEach { print(it) }
        }
    }
    private fun encryptionAbc(input: String, step: Int, output: String) {
        val list: MutableList<Char> = mutableListOf()
        for (i in input.indices) {
            var l = 25;
            var check = 0
            for (r in 0..25) {
                when (input[i]) {
                    alphabets[r] -> list.add(alphabets[r + step])
                    alphabets2[r] -> list.add(alphabets2[r + step])
                    else -> check++
                }
                l--
            }
            when (check) {
                26 -> list.add(input[i])
            }
        }
        if (output != "") {
            File(output).writeText("")
            File(output).printWriter().use { out ->
                list.forEach {
                    out.print(it)
                }
            }
        } else {
            list.forEach { print(it) }
        }
    }

    fun decryptionAbc(input: String, step: Int, output: String) {
        val list: MutableList<Char> = mutableListOf()
        for (i in input.indices) {
            var check = 0
            for (r in 26..50) {
                when (input[i]) {
                    alphabets[r] -> list.add(alphabets[r - step])
                    alphabets2[r] -> list.add(alphabets2[r - step])
                    else -> check++
                }
            }
            when (check) {
                26 -> list.add(input[i])
            }
        }
        if (output != "") {
            File(output).writeText("")
            File(output).printWriter().use { out ->
                list.forEach {
                    out.print(it)
                }
            }
        } else {
            list.forEach { print(it) }
        }
    }

    fun menu(mode: String, key: Int, data: String, output: String, algoritm: String) {
        when (algoritm) {
            "unicode" -> when (mode) {
                "enc" -> encryption(data, key, output)
                "dec" -> decryption(data, key, output)
            }
            "shift" -> when (mode) {
                "enc" -> encryptionAbc(data, key, output)
                "dec" -> decryptionAbc(data, key, output)
            }
        }
    }
}
