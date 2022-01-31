package com.dcgabriel.myuark.ui.Events

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.dcgabriel.myuark.model.events.RssItem
import com.dcgabriel.myuark.ui.Adapters.EventsAdapter
import com.dcgabriel.myuark.ui.BaseActivity
import com.dcgabriel.myuark.ui.Main.MainActivity
import com.example.myuark.databinding.ActivityEventsBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AndroidEntryPoint
class EventsActivity : BaseActivity() {
    private val viewModel: EventsViewModel by viewModels()
    private lateinit var adapter: EventsAdapter
    private lateinit var binding: ActivityEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initSubscription()
    }

    private fun initSubscription() {
        disposables.add(viewModel.liveEventsData()
            .subscribe() {
                adapter.setData(viewModel.mapDates(it.channel?.items))
                Log.d("EventsActivity---------", "subbed")
            })

        disposables.addAll(
            adapter.clickOpen()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    openBrowser(it.link.toString())
                },
            adapter.clickSave()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    save(it)
                },
            adapter.clickShare()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    share(it)
                }
        )
    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        adapter = EventsAdapter(this)
        binding.eventsRecyclerview.layoutManager = layoutManager
        binding.eventsRecyclerview.adapter = adapter
    }

    fun share(event: RssItem) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, HtmlCompat.fromHtml((
                    event.title +
                            event.description.toString().substringBefore("View on site") +
                            event.link)
                , HtmlCompat.FROM_HTML_MODE_LEGACY))
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }

    fun save(event: RssItem) {
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, event.title)
            putExtra(CalendarContract.Events.DESCRIPTION, event.description)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun clickOptions(view: View) = showHideFAB(binding.optionsFab, arrayListOf(binding.openAcademicCalendar, binding.openHoliday,binding.openBrowser,))
    fun clickBrowser(view: View) = openBrowser("https://calendars.uark.edu/")
    fun clickAcademicCalendar(view: View) = openBrowser("https://registrar.uark.edu/academic-dates/3-year-academic-calendar/2021-2022-five-year-academic-calendar.php")
    fun clickHoliday(view: View) = openBrowser("https://vcfa.uark.edu/fayetteville-policies-procedures/vcfa/4092.php")
}