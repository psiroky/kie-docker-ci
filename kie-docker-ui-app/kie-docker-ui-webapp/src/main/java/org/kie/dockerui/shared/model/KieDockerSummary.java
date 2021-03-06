package org.kie.dockerui.shared.model;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.List;

public class KieDockerSummary implements IsSerializable {
    private int imagesCount;
    private int containersCount;
    private int kieImagesCount;
    private int kieContainersCount;
    private List<KieImage> kieImages;

    public KieDockerSummary() {
    }

    public void setImagesCount(int imagesCount) {
        this.imagesCount = imagesCount;
    }

    public void setContainersCount(int containersCount) {
        this.containersCount = containersCount;
    }

    public void setKieImages(List<KieImage> kieImages) {
        this.kieImages = kieImages;
    }

    public void setKieImagesCount(int kieImagesCount) {
        this.kieImagesCount = kieImagesCount;
    }

    public void setKieContainersCount(int kieContainersCount) {
        this.kieContainersCount = kieContainersCount;
    }

    public int getImagesCount() {
        return imagesCount;
    }

    public int getContainersCount() {
        return containersCount;
    }

    public List<KieImage> getKieImages() {
        return kieImages;
    }

    public int getKieImagesCount() {
        return kieImagesCount;
    }

    public int getKieContainersCount() {
        return kieContainersCount;
    }
}
