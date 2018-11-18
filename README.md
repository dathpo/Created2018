# Created2018 - Real-time Augmented Reality SDR Spectrum Analyser

## SDR work:
* Installing dependencies and getting to know the LimeSDR tools and hardware
* Set up RX in SDR to scan the most common WiFi frequencies and log data into dataset
* Set up server to send SDR data to several clients
* Attempt to compile LimeSDR on Raspberry Pi 3

## Data processing:
The data obtained from the SDR-Radio is saved to a .txt file and processed by a Python script. The script generates a graphical output from the data, displaying the magnitude of the frequency spectrum analysed . A HTML page is generated and displayed on the Google Glasses for visualization. The script is automated and executed by a Cron-Job every minute.

Tried connecting limeSDR to the Raspberri Pi 3 and use GNU Radio for measuring the power of spectrum, Sadly the GNU radio provided to be too complex to set up and or use thus Lime suite was tryed instead

For Google Glass we tried to get a live stream of data displayed to the user as he is walking around. We set up a server using NodeJS and socket.io for the user to connect to, but because we have not managed to get the stream directly into the native Java code, we set up a client webpage with client socket.io JS our app uses to show the data to the user. The whole work is mainly a proof of concept with missing bits of functionality and placeholders, but it works!
