package com.lixm.notes.livedataimport androidx.lifecycle.LiveDataimport com.lixm.notes.livedata.dao.WordDaoclass WordRepository(private val wordDao: WordDao) {    val allWords:LiveData<List<Word>> = wordDao.getAllWords()    suspend fun insert(word:Word){        wordDao.insert(word)    }}