package mvvmApp.ui

import androidx.lifecycle.ViewModel
import mvvmApp.repositories.NewsRepository

class newsViewModel( val newsRepository: NewsRepository
): ViewModel()
{
}