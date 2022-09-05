package com.bulanovdm.ssgql

import com.apollographql.apollo3.ApolloClient
import com.bulanovdm.ssgql.graphql.LaunchDetailsQuery
import com.bulanovdm.ssgql.graphql.PastLaunchesListQuery
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.servlet.ModelAndView

@Controller
class LaunchesController(val apolloClient: ApolloClient) {

    @GetMapping
    suspend fun getAllLaunches(): ModelAndView {
        val modelAndView = ModelAndView("index")
        val response = apolloClient.query(PastLaunchesListQuery(200)).execute()
        val launchesPast: List<PastLaunchesListQuery.LaunchesPast?>? = response.data?.launchesPast?.sortedBy { it?.id }
        modelAndView.addObject("launches", launchesPast)
        return modelAndView
    }

    @GetMapping("/launch/{id}")
    suspend fun getLaunch(@PathVariable("id") id: String): ModelAndView {
        val modelAndView = ModelAndView("launch")
        val response = apolloClient.query(LaunchDetailsQuery(id)).execute()
        val launch: LaunchDetailsQuery.Launch? = response.data?.launch
        modelAndView.addObject("launch", launch)
        return modelAndView
    }
}