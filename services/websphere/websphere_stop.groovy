/*******************************************************************************
* Copyright (c) 2012 GigaSpaces Technologies Ltd. All rights reserved
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*       http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*******************************************************************************/
import groovy.util.ConfigSlurper


websphereConfig = new ConfigSlurper().parse(new File("websphere-service.properties").toURL())

println "websphere_stop.groovy: Executing ${websphereConfig.stopScript} ..."

new AntBuilder().sequential {
	exec(executable:"${websphereConfig.stopScript}", osfamily:"unix") {        
		arg(value:"server1")
		arg(value:"-quiet")
		arg(value:"-password")
		arg(value:"admin")
		arg(value:"-username")
		arg(value:"admin")		     
	}
}

println "websphere_stop.groovy: Ended successfully"







