/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package at.fhv.lindale.api.plugin.utils;

import javafx.scene.layout.Pane;

/**
 * @author  Morent Jochen <jochen.morent@students.fhv.at>
 * @org     FHV <fhv.at>
 * @project Lindale_API_Plugin
 * @date    16.12.2013
 */
public interface I_MediaPlayer
{
    public Pane getView(E_MediaPlayerViewType type);
    public void setPlaylist();
    public void play();
    public void pause();
    public void next();
    public void previous();
    public void setLoopMode(E_MediaPlayerLoopMode mode);
    public void setShufleMode(boolean on);
}
