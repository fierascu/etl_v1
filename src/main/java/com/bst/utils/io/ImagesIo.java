package com.bst.utils.io;

import com.bst.data.ProdFeedImage;
import com.bst.utils.Utils;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.bst.utils.Utils.IMG_DIR;
import static com.bst.utils.Utils.isLocalFile;

public class ImagesIo {

    static Logger log = Logger.getLogger(ImagesIo.class.getName());

    public static void downloadListImg(List<String> imgs) {
        for (String img : imgs) {
            String[] fileNameUrl = img.split("/");
            String fileName = fileNameUrl[fileNameUrl.length - 1].toLowerCase();

            if (!isLocalFile(IMG_DIR + fileName)) {
                try (InputStream in = new URL(img).openStream()) {
                    Files.copy(in, Paths.get(IMG_DIR + fileName), StandardCopyOption.REPLACE_EXISTING);
                    log.trace(img + " -> " + fileName);
                } catch (Exception e) {
                    log.error(e.getCause());
                }
            } else {
                log.trace(img + " -> " + fileName + " exist on localdrive. Skiping it from download.");
            }
        }
    }


    public static void download(List<ProdFeedImage> pfil) {
        log.trace("ProdFeedImages for download: " + pfil.size());
        List<String> imgs = pfil.stream().map(e -> e.getProdPojoImage()).collect(Collectors.toList());
        log.trace("imgs: " + imgs.size());

        // make it unique
        log.trace("uniques imgs: " + imgs.size());
        imgs = new ArrayList<>(new HashSet<>(imgs));

        downloadListImg(imgs);
    }
}
