package com.daima.bot

import com.jagrosh.jdautilities.command.Command
import com.jagrosh.jdautilities.command.CommandClientBuilder
import com.jagrosh.jdautilities.command.CommandEvent
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import io.github.cdimascio.dotenv.dotenv

val dotenv = dotenv()

class CommandBot {
    lateinit var jda: JDA
    private val commandPrefix = "!"

    fun main(token: String) {
        val commandClient = CommandClientBuilder()
            .setOwnerId("570243143958528010")
            .setPrefix(commandPrefix)
            //.addCommands(Ping())
            .build()

        jda = JDABuilder.createDefault(token)
            .addEventListeners(commandClient)
            .build()
    }
}

fun main() {
    val bot = CommandBot()
    bot.main(dotenv["TOKEN"])
}