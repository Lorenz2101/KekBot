package com.godson.kekbot.commands.fun;

import com.darichey.discord.api.Command;
import com.darichey.discord.api.CommandCategory;
import com.godson.kekbot.KekBot;
import com.godson.kekbot.Responses.Action;

import java.util.Random;

public class Roll {
    public static Command roll = new Command("roll")
            .withCategory(CommandCategory.FUN)
            .withDescription("Rolls a dice. Specify a number to give the bot that number sided die.")
            .withUsage("{p}roll {number}")
            .onExecuted(context -> {
                Random random = new Random();
                int defaultDie = random.nextInt(6)+1;
                int specifiedDie = 0;
                String args[] = context.getArgs();
                if (args.length == 0) {
                    context.getTextChannel().sendMessage(Emojify.emojify(String.valueOf(defaultDie))).queue();
                } else {
                    try {
                        specifiedDie = random.nextInt(Integer.valueOf(args[0]));
                        context.getTextChannel().sendMessage(Emojify.emojify(String.valueOf(specifiedDie))).queue();
                    } catch (NumberFormatException e) {
                        context.getTextChannel().sendMessage(KekBot.respond(context, Action.NOT_A_NUMBER, "`" + args[0] + "`")).queue();
                    }
                }
            });

}
