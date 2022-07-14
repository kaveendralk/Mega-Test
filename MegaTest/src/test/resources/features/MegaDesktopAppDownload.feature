@tag1
Feature: Download the MEGA Desktop App for your platform feature

  @tag1
  Scenario Outline: Validate download Linux distro
    Given Open the browser
    And Navigate to MEGA desktop page
    Then Click Linux button which is comes under Download the MEGA Desktop App for your platform
    When Download each distro <distroName> and validate the download link <downloadLink>
    Then Validate downloaded distro <fileName> in download folder
    Then Close the browser

    Examples: 
      | distroName 			   | downloadLink 																															  	| fileName                              |
      | Arch Linux  			 | https://mega.nz/linux/repo/Arch_Extra/x86_64/megasync-x86_64.pkg.tar.zst 			| megasync-x86_64.pkg.tar.zst           |
      | CentOS 7           | https://mega.nz/linux/repo/CentOS_7/x86_64/megasync-CentOS_7.x86_64.rpm  			| megasync-CentOS_7.x86_64.rpm          |
			| Debian  9          | https://mega.nz/linux/repo/Debian_9.0/amd64/megasync-Debian_9.0_amd64.deb			| amd64/megasync-Debian_9.0_amd64.deb   |
			| elementary OS Juno | https://mega.nz/linux/repo/xUbuntu_18.04/amd64/megasync-xUbuntu_18.04_amd64.deb| amd64/megasync-xUbuntu_18.04_amd64.deb|
			| Fedora 30    			 | https://mega.nz/linux/repo/Fedora_30/x86_64/megasync-Fedora_30.x86_64.rpm 			| megasync-Fedora_30.x86_64.rpm         |
	