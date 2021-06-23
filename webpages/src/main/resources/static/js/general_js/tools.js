	//获取父页面传来的参数方法
	function getQueryString(name) {
	    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i'); 
	    var r = window.location.search.substr(1).match(reg); 
	    if (r != null) { 
	        return unescape(r[2]); 
	    } 
	    return null; 
	}
var postDownLoadFileByArr = function (options,arr) {
    var config = $.extend(true, { method: 'post' }, options);
    var $iframe = $('<iframe id="down-file-iframe" />');
    var $form = $('<form target="down-file-iframe" method="' + config.method + '" />');
    $form.attr('action', config.url);
    for (var key in config.data) {
    	console.log("key:"+config.data[key]);
    	layer.msg(config.data[key]);
        $form.append('<input type="hidden" name="' + key + '" value="' + config.data[key] + '" />');
    }
	for(var j = 0; j < arr.length; j++) {
        console.log("j:"+j);
        $form.append('<input type="hidden" name="' + j + '" value="' + arr[j] + '" />');
	}
    $iframe.append($form);
    $(document.body).append($iframe);
    $form[0].submit();
    $iframe.remove();
}

/*===================post请求下载文件
 * options:{
 * url:'',  //下载地址
 * data:{name:value}, //要发送的数据
 * method:'post'
 * }
 */
var postDownLoadFile = function (options) {
    var config = $.extend(true, { method: 'post' }, options);
    var $iframe = $('<iframe id="down-file-iframe" />');
    var $form = $('<form target="down-file-iframe" method="' + config.method + '" />');
    $form.attr('action', config.url);
    for (var key in config.data) {
    	console.log("key:"+config.data[key]);
    	layer.msg(config.data[key]);
        $form.append('<input type="hidden" name="' + key + '" value="' + config.data[key] + '" />');
    }
    $iframe.append($form);
    $(document.body).append($iframe);
    $form[0].submit();
    $iframe.remove();
}
Array.prototype.indexOf = function(val) { 
for (var i = 0; i < this.length; i++) { 
if (this[i] == val) return i; 
} 
return -1; 
}
Array.prototype.remove = function(val) { 
var index = this.indexOf(val); 
if (index > -1) { 
this.splice(index, 1); 
} 
}

function Map() {     
    /** 存放键的数组(遍历用到) */    
    this.keys = new Array();     
    /** 存放数据 */    
    this.data = new Object();     
         
    /**   
     * 放入一个键值对   
     * @param {String} key   
     * @param {Object} value   
     */    
    this.put = function(key, value) {     
        if(this.data[key] == null){     
            this.keys.push(key);     
        }     
        this.data[key] = value;     
    };     
         
    /**   
     * 获取某键对应的值   
     * @param {String} key   
     * @return {Object} value   
     */    
    this.get = function(key) {     
        return this.data[key];     
    };     
         
    /**   
     * 删除一个键值对   
     * @param {String} key   
     */    
    this.remove = function(key) {     
        this.keys.remove(key);     
        this.data[key] = null;     
    };     
         
    /**   
     * 遍历Map,执行处理函数   
     *    
     * @param {Function} 回调函数 function(key,value,index){..}   
     */    
    this.each = function(fn){     
        if(typeof fn != 'function'){     
            return;     
        }     
        var len = this.keys.length;     
        for(var i=0;i<len;i++){     
            var k = this.keys[i];     
            fn(k,this.data[k],i);     
        }     
    };     
         
    /**   
     * 获取键值数组(类似Java的entrySet())   
     * @return 键值对象{key,value}的数组   
     */    
    this.entrys = function() {     
        var len = this.keys.length;     
        var entrys = new Array(len);     
        for (var i = 0; i < len; i++) {     
            entrys[i] = {     
                key : this.keys[i],     
                value : this.data[i]     
            };     
        }     
        return entrys;     
    };     
         
    /**   
     * 判断Map是否为空   
     */    
    this.isEmpty = function() {     
        return this.keys.length == 0;     
    };     
         
    /**   
     * 获取键值对数量   
     */    
    this.size = function(){     
        return this.keys.length;     
    };     
         
    /**   
     * 重写toString    
     */    
    this.toString = function(){     
        var s = "{";     
        for(var i=0;i<this.keys.length;i++,s+=','){     
            var k = this.keys[i];     
            s += k+"="+this.data[k];     
        }     
        s+="}";     
        return s;     
    };     
}
//将json拼接成url里的参数
/*let obj = {
name:'xiaoming',
sex:'男',
age:'16'
}
changeJSON2QueryString(obj);
结果是：name=xiaoming&sex=男&age=16
 */
function changeJSON2QueryString(JSON){
    var temp = [];
    for(var k in JSON){
        temp.push(k + "=" + encodeURIComponent(JSON[k]));
    }
    return temp.join("&");
}