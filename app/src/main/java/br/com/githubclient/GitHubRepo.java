package br.com.githubclient;

/**
 * Created by Gustavo Toporowicz on 16/11/2017.
 */

public class GitHubRepo {
    private int id;
    private String name;
    private String html_url;

    public GitHubRepo() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHtml_url() {
        return html_url;
    }
}
