#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <iostream>
#include <QMainWindow>
#include <QMediaPlayer>
#include <QFileDialog>

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

private slots:

    void on_OpenFile_clicked();

    void on_Play_clicked();

    void on_Pause_clicked();

    void on_Stop_clicked();

    void on_Mute_clicked();

    void on_VolumeSlider_actionTriggered(int action);

    void on_actionOpen_File_triggered();

    void on_actionPlay_triggered();

    void on_actionPause_triggered();

    void on_actionStop_triggered();

    void on_songSlider_actionTriggered(int action);

    void on_songSlider_sliderMoved(int position);

private:
    Ui::MainWindow *ui;
    QMediaPlayer * newPlayer;

};

#endif // MAINWINDOW_H
