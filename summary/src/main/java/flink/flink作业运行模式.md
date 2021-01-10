

#回答

[PerJob]
* 独享Dispatcher与ResourceManager
* 按需要申请资源（即TaskExecutor)
* 适合执行时间较长的大作业

[Session]
* 共享Dispatcher与ResourceManager
* 共享资源（即TaskExecutor)
* 适合规模小、执行时间短的作业

