package main

import (
	"fmt"

	"github.com/google/gopacket/pcap"
)

func main() {
	//  获取 libpcap 的版本
	version := pcap.Version()
	fmt.Println(version)
	//  获取网卡列表
	var devices []pcap.Interface
	devices, _ := pcap.FindAllDevs()
	fmt.Println(devices)
}
