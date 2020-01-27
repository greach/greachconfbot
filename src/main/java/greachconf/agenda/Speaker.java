package greachconf.agenda;

import io.micronaut.core.annotation.Introspected;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

@Introspected
public class Speaker implements Comparable<Speaker> {

    @Nonnull
    private String uid;

    @Nonnull
    private String name;

    @Nullable
    private List<String> bio;

    @Nullable
    private String twitter;

    @Nullable
    private String image;

    @Nullable
    private String companyImage;

    @Nullable
    private String companyName;

    @Nullable
    private String companyLink;

    @Nullable
    private String link;

    public Speaker() {}

    @Nonnull
    public String getUid() {
        return uid;
    }

    public void setUid(@Nonnull String uid) {
        this.uid = uid;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public void setName(@Nonnull String name) {
        this.name = name;
    }

    @Nullable
    public List<String> getBio() {
        return bio;
    }

    public void setBio(@Nullable List<String> bio) {
        this.bio = bio;
    }

    @Nullable
    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(@Nullable String twitter) {
        this.twitter = twitter;
    }

    @Nullable
    public String getImage() {
        return image;
    }

    public void setImage(@Nullable String image) {
        this.image = image;
    }

    @Nullable
    public String getCompanyImage() {
        return companyImage;
    }

    public void setCompanyImage(@Nullable String companyImage) {
        this.companyImage = companyImage;
    }

    @Nullable
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(@Nullable String companyName) {
        this.companyName = companyName;
    }

    @Nullable
    public String getCompanyLink() {
        return companyLink;
    }

    public void setCompanyLink(@Nullable String companyLink) {
        this.companyLink = companyLink;
    }

    @Nullable
    public String getLink() {
        return link;
    }

    public void setLink(@Nullable String link) {
        this.link = link;
    }

    @Override
    public int compareTo(Speaker o) {
        return replaceAccents(getName().toLowerCase()).compareTo(replaceAccents(o.getName().toLowerCase()));
    }

    String replaceAccents(String str) {
        return str.replaceAll("á", "a")
                .replaceAll("é", "e")
                .replaceAll("ó", "o")
                .replaceAll("é", "e")
                .replaceAll("ú", "u");

    }
}
