package net.allthemods.allthemodium.data.provider;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtAccounter;
import net.minecraft.nbt.NbtIo;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.DataFixTypes;
import net.minecraft.util.datafix.DataFixers;

import com.google.common.hash.Hashing;
import com.google.common.hash.HashingOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ATMStructureProvider implements DataProvider {
    
    private static final String EXTENSION = ".nbt";
    
    private final PackOutput.PathProvider pathProvider;
    private final Collection<Path> inputs;
    
    public ATMStructureProvider(PackOutput output, Collection<Path> inputs) {
        this.pathProvider = output.createPathProvider(PackOutput.Target.DATA_PACK, "structure");
        this.inputs = inputs;
    }
    
    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        List<CompletableFuture<?>> tasks = new ArrayList<>();
        for (Path input : this.inputs) {
            try (Stream<Path> files = Files.walk(input)) {
                files.filter(file -> file.toString().endsWith(ATMStructureProvider.EXTENSION))
                        .forEach(file -> tasks.add(CompletableFuture.runAsync(() -> this.upgrade(cache, input, file), Util.backgroundExecutor().forName("ATMStructureProvider"))));
            } catch (IOException e) {
                return CompletableFuture.failedFuture(e);
            }
        }
        return CompletableFuture.allOf(tasks.toArray(CompletableFuture[]::new));
    }
    
    private void upgrade(CachedOutput cache, Path input, Path file) {
        Path relative = input.relativize(file);
        String namespace = relative.getName(0).toString();
        String path = relative.subpath(1, relative.getNameCount()).toString().replace('\\', '/');
        Identifier id = Identifier.fromNamespaceAndPath(namespace, path.substring(0, path.length() - ATMStructureProvider.EXTENSION.length()));
        try {
            CompoundTag tag = NbtIo.readCompressed(file, NbtAccounter.unlimitedHeap());
            CompoundTag updated = DataFixTypes.STRUCTURE.updateToCurrentVersion(DataFixers.getDataFixer(), tag, NbtUtils.getDataVersion(tag, 500));
            NbtUtils.addCurrentDataVersion(updated);
            
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            HashingOutputStream hashing = new HashingOutputStream(Hashing.sha1(), bytes);
            NbtIo.writeCompressed(updated, hashing);
            cache.writeIfNeeded(this.pathProvider.file(id, "nbt"), bytes.toByteArray(), hashing.hash());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
    
    @Override
    public String getName() {
        return "Structures";
    }
}
