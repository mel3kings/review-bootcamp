package Snippets;


import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by krishna on 29/03/2016.
 */
@Slf4j
public class SftpLoader {
  ChannelSftp channel;
  String host;
  int port;
  String userName;
  String password;
  String privateKey;

  public SftpLoader(String host, int port, String userName, String password, String privateKey) throws JSchException {
    this.host = host;
    this.port = port;
    this.userName = userName;
    this.password = password;
    this.privateKey = privateKey;
    channel = connect();
  }

  private ChannelSftp connect() throws JSchException {
    log.info("connecting ...");
    JSch jsch = new JSch();
    Session session = jsch.getSession(userName, host, port);
    session.setPassword(password);
    //jsch.addIdentity(privateKey);
    java.util.Properties config = new java.util.Properties();
    config.put("StrictHostKeyChecking", "no");
    session.setConfig(config);
    session.connect();
    Channel channel = session.openChannel("sftp");
    channel.connect();
    System.out.println("connected !!!");
    return (ChannelSftp) channel;
  }

  public void transferDirToRemote(String localDir, String remoteDir) throws SftpException, FileNotFoundException {
    log.info("local dir: " + localDir + ", remote dir: " + remoteDir);
    File localFile = new File(localDir);
    //channel.mkdir(remoteDir);
    log.info(channel.pwd());
    System.out.println(channel.ls(channel.pwd()));

    channel.cd(remoteDir);
    log.info("Current FILES: ");
    System.out.println(channel.ls(channel.pwd()));

    for (File localChildFile : localFile.listFiles()) {
      if (localChildFile.isFile()) {
        System.out.println("file : " + localChildFile.getName());
        transferFileToRemote(localChildFile.getAbsolutePath(), remoteDir);

      } else if (localChildFile.isDirectory()) {
        try {
          channel.stat(localChildFile.getName());
        } catch (Exception e) {
          channel.mkdir(localChildFile.getName());
        }
        System.out.println("dir: " + localChildFile.getName());
        transferDirToRemote(localChildFile.getAbsolutePath(), remoteDir + "/" + localChildFile.getName());
        channel.cd("..");
      }
    }

  }

  public void transferFileToRemote(String localFile, String remoteDir) throws SftpException, FileNotFoundException {
    channel.put(new FileInputStream(new File(localFile)), new File(localFile).getName(), ChannelSftp.OVERWRITE);
  }

  public void transferToLocal(String remoteDir, String remoteFile, String localDir) throws SftpException, IOException {
    channel.cd(remoteDir);
    byte[] buffer = new byte[1024];
    BufferedInputStream bis = new BufferedInputStream(channel.get(remoteFile));

    File newFile = new File(localDir);
    OutputStream os = new FileOutputStream(newFile);
    BufferedOutputStream bos = new BufferedOutputStream(os);

    System.out.println("writing files ...");
    int readCount;
    while ((readCount = bis.read(buffer)) > 0) {
      bos.write(buffer, 0, readCount);
    }
    System.out.println("completed !!!");
    bis.close();
    bos.close();
  }
}