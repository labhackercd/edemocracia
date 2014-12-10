<%

	/*	Configuração dos labels do fórum para a view de configuração: Termos Utilizados  */
	
	String labelRecentPosts = preferences.getValue(MBLabelKeys.RECENT_POSTS, "");
	String labelForumAddCategory = preferences.getValue(MBLabelKeys.FORUM_ADD_CATEGORY, "");
	String labelForumAddSubcategory = preferences.getValue(MBLabelKeys.FORUM_ADD_SUBCATEGORY, "");
	String labelPostNewThread = preferences.getValue(MBLabelKeys.POST_NEW_THREAD, "");

	String labelForumCategories = preferences.getValue(MBLabelKeys.FORUM_CATEGORIES, "");
	String labelForumSubcategories = preferences.getValue(MBLabelKeys.FORUM_SUBCATEGORIES, "");
	String labelThreads = preferences.getValue(MBLabelKeys.THREADS, "");

	String labelCategory = preferences.getValue(MBLabelKeys.FORUM_CATEGORY, "");
	String labelPosts = preferences.getValue(MBLabelKeys.POSTS, "");
	String labelThread = preferences.getValue(MBLabelKeys.THREAD, "");
	String labelNumOfCategories = preferences.getValue(MBLabelKeys.NUM_OF_CATEGORIES, "");	
	String labelNewCategory = preferences.getValue(MBLabelKeys.FORUM_NEW_CATEGORY, "");	
	String labelParentCategory = preferences.getValue(MBLabelKeys.FORUM_PARENT_CATEGORY, "");	
	String labelMergeCategory = preferences.getValue(MBLabelKeys.MERGE_WITH_PARENT_CATEGORY, "");	
	String labelNewMessage = preferences.getValue(MBLabelKeys.NEW_MESSAGE, "");
	
	String labelLockThread = preferences.getValue(MBLabelKeys.LOCK_THREAD, "");
	String labelUnlockThread = preferences.getValue(MBLabelKeys.UNLOCK_THREAD, "");
	String labelMoveThread = preferences.getValue(MBLabelKeys.MOVE_THREAD, "");	
	
	String msgNoThreads = preferences.getValue(MBLabelKeys.NO_THREADS_IN_THIS_CATEGORY, "");	
	String msgNoSubscribedToCategories = preferences.getValue(MBLabelKeys.NO_SUBSCRIBED_TO_ANY_CATEGORIES, "");	
	String msgNoSubscribedToThreads = preferences.getValue(MBLabelKeys.NO_SUBSCRIBED_TO_ANY_THREADS, "");
	

%>