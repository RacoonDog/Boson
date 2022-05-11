package io.github.racoondog.boson.mixin.devenv;

import net.devtech.arrp.ARRP;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ARRP.class)
public abstract class ARRPMixin {
    @Redirect(method = "onPreLaunch", at = @At(value = "INVOKE", target = "Lorg/apache/logging/log4j/Logger;info(Ljava/lang/String;)V"), remap = false)
    private void redirect(Logger instance, String s) {
        //Remove "I used the json to destroy the json log message
    }
}
