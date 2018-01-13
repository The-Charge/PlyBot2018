package org.usfist.frc2619.PlyBot2018.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Recorder
{
    private static final long _DEFAULT_RECORD_INTERVAL_MILLIS = 100;
    private long _recordIntervalMillis;
    private String _filePath;
    private boolean _isRecording;
    private BufferedWriter _writer;
    private StringBuilder _stringBuilder;
    private long _startTime;
    private long _lastWriteTime;

    public Recorder()
    {
        //TODO: Change default to /u/recorded_data.csv
        this("/u/recorded_data.csv");
    }


    public Recorder(String filePath)
    {
        this(filePath, _DEFAULT_RECORD_INTERVAL_MILLIS);
    }

    public Recorder(String filePath, long recordIntervalMillis)
    {
        this._filePath = filePath;
        this._recordIntervalMillis = recordIntervalMillis;
    }

    /**
     * Must be called to start recording
     * Will set up file writer, and set internal flags & variables
     * @return whether or not recording is going (false if error)
     */
    public boolean startRecording()
    {
        try
        {
            _writer = new BufferedWriter(new FileWriter(_filePath));
            _stringBuilder = new StringBuilder();
            _isRecording = true;
            _startTime = System.currentTimeMillis();
        }
        catch (IOException e)
        {
            e.printStackTrace();
            _isRecording = false;
        }
        return _isRecording;
    }

    /**
     * Must be called when recording needs to be stopped
     * Will flush and close file writer, and clean up variables
     */
    public void stopRecording()
    {
        try
        {
            _writer.flush();
            _writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        _isRecording = false;
    }

    /**
     * @return Whether or not this is recording
     */
    public boolean isRecording()
    {
        return _isRecording;
    }

    /**
     * @return How long the recording has been running
     */
    public long currentRecordingTimeMillis()
    {
        return System.currentTimeMillis() - _startTime;
    }

    private long _timeSinceLastWriteMillis()
    {
        return System.currentTimeMillis() - _lastWriteTime;
    }

    public void write(double... args)
    {
        // Only write if we're recording and we haven't written in a while
        if(isRecording() && _timeSinceLastWriteMillis() >= _recordIntervalMillis)
        {
            // Build up the string:
            _stringBuilder.append(currentRecordingTimeMillis());
            // Go through each of the arguments:
            for (double arg : args)
            {
                _stringBuilder.append(",");
                _stringBuilder.append(arg);
            }
            _stringBuilder.append(System.lineSeparator());
            try
            {
                _writer.write(_stringBuilder.toString());
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            _stringBuilder.delete(0,_stringBuilder.length());
            _lastWriteTime = System.currentTimeMillis();
        }
        else
        {
            //throw new RuntimeException("Recorder.write() called when not recording!");
        }
    }

}
