#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
    this->newPlayer = new QMediaPlayer;

    connect(this->newPlayer,&QMediaPlayer::positionChanged,[&] (qint64 position){
        ui->progressBar->setValue(position);
    });

    connect(this->newPlayer, &QMediaPlayer::durationChanged,[&] (qint64 durration){
        ui->progressBar->setMaximum(durration);
    });

    connect(this->newPlayer, &QMediaPlayer::positionChanged, [&] (qint64 position){
        ui->songSlider->setValue(position);
    });

    connect(this->newPlayer, &QMediaPlayer::durationChanged,[&] (qint64 durration){
        ui->songSlider->setMaximum(durration);
    });

    //setStyleSheet("C:\Users\wisne\Documents\Programming\MusicPlayerPA9+\control_play.png");

    //this->setStyleSheet();

}

MainWindow::~MainWindow()
{
    delete ui;
}


void MainWindow::on_OpenFile_clicked()
{
    QString newFile;
    newFile = QFileDialog::getOpenFileName(this, "Open a file with a .mp3");
    if(newFile.isEmpty()){
        return;
    }

    this->newPlayer->setMedia(QUrl::fromLocalFile(newFile));
    this->newPlayer->setVolume(ui->VolumeSlider->value());

    on_Play_clicked();
}

void MainWindow::on_Play_clicked()
{
this->newPlayer->play();
}

void MainWindow::on_Pause_clicked()
{
this->newPlayer->pause();
}

void MainWindow::on_Stop_clicked()
{
this->newPlayer->stop();
}

void MainWindow::on_Mute_clicked()
{

    if(ui->Mute->text() == "Mute"){
        this->newPlayer->setMuted(true);
        ui->Mute->setText("Unmute");
    }
    else{

        this->newPlayer->setMuted(false);
        ui->Mute->setText("Mute");
    }
}


void MainWindow::on_VolumeSlider_actionTriggered(int action)
{
    this->newPlayer->setVolume(ui->VolumeSlider->value());
}




void MainWindow::on_actionOpen_File_triggered()
{
    QString newFile;
    newFile = QFileDialog::getOpenFileName(this, "Open a file with a .mp3");
    if(newFile.isEmpty()){
        return;
    }

    this->newPlayer->setMedia(QUrl::fromLocalFile(newFile));
    this->newPlayer->setVolume(ui->VolumeSlider->value());

    on_Play_clicked();
}

void MainWindow::on_actionPlay_triggered()
{
    this->newPlayer->play();
}

void MainWindow::on_actionPause_triggered()
{
    this->newPlayer->pause();
}

void MainWindow::on_actionStop_triggered()
{
    this->newPlayer->stop();
}


void MainWindow::on_songSlider_sliderMoved(int position)
{
    this->newPlayer->setPosition(position);
}
void MainWindow::on_songSlider_actionTriggered(int action)
{
    ui->songSlider->setValue(action);
}

