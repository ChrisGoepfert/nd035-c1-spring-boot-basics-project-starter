package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import java.util.List;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

    private final UserMapper userMapper;
    private final FileMapper fileMapper;

    public void createFileForUser(File file, String username) {
        User user = userMapper.findByUsername(username);

        file.setUserId(user.getUserId());

        fileMapper.create(file);
    }

    public List<File> findFilesByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return fileMapper.findByUserId(user.getUserId());
    }

    public void deleteFile(String fileId) {
        fileMapper.delete(fileId);
    }

    public File getFile(String fileId) {
        return fileMapper.findById(fileId);
    }

    public boolean isFileNameAvailable(String originalFilename, String username) {
        User user = userMapper.findByUsername(username);
        Integer filesWithName = fileMapper.getFileCount(originalFilename, user.getUserId());
        return filesWithName <= 0;
    }
}