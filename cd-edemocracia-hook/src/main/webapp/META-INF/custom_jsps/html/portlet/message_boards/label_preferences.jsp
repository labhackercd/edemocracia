<%

	/*  Configuração dos labels do fórum para as views  */

	String forumAddCategory = preferences.getValue(MBLabelKeys.FORUM_ADD_CATEGORY,MBLabelKeys.FORUM_ADD_CATEGORY);
	String forumAddSubcategory = preferences.getValue(MBLabelKeys.FORUM_ADD_SUBCATEGORY,MBLabelKeys.FORUM_ADD_SUBCATEGORY);
	String postNewThread = preferences.getValue(MBLabelKeys.POST_NEW_THREAD,MBLabelKeys.POST_NEW_THREAD);
		
	String forumCategories = preferences.getValue(MBLabelKeys.FORUM_CATEGORIES,MBLabelKeys.FORUM_CATEGORIES);
	String forumSubcategories = preferences.getValue(MBLabelKeys.FORUM_SUBCATEGORIES,MBLabelKeys.FORUM_SUBCATEGORIES);
	String threads = preferences.getValue(MBLabelKeys.THREADS,MBLabelKeys.THREADS);
	
	String labelThread = preferences.getValue(MBLabelKeys.THREAD,MBLabelKeys.THREAD);
	String labelPosts = preferences.getValue(MBLabelKeys.POSTS,MBLabelKeys.POSTS);
	
	String labelNumOfCategories = preferences.getValue(MBLabelKeys.NUM_OF_CATEGORIES,MBLabelKeys.NUM_OF_CATEGORIES);
	
	String msgNoThreadsInThisCategory = preferences.getValue(MBLabelKeys.NO_THREADS_IN_THIS_CATEGORY,MBLabelKeys.NO_THREADS_IN_THIS_CATEGORY);
	String msgNoSubscribedToAnyCategories = preferences.getValue(MBLabelKeys.NO_SUBSCRIBED_TO_ANY_CATEGORIES,MBLabelKeys.NO_SUBSCRIBED_TO_ANY_CATEGORIES);
	String msgNoSubscribedToAnyThreads = preferences.getValue(MBLabelKeys.NO_SUBSCRIBED_TO_ANY_THREADS,MBLabelKeys.NO_SUBSCRIBED_TO_ANY_THREADS);


%>