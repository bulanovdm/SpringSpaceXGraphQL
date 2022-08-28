package com.bulanovdm.ssgql

import com.apollographql.apollo3.ApolloClient
import com.bulanovdm.ssgql.graphql.LaunchDetailsQuery
import com.bulanovdm.ssgql.graphql.PastLaunchesListQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("/api")
class LaunchesRestController(val apolloClient: ApolloClient) {

    @GetMapping("/launches")
    suspend fun getAllLaunches(@RequestParam(defaultValue = "100") limit: Int): List<PastLaunchesListQuery.LaunchesPast?>? {
        val response  = apolloClient.query(PastLaunchesListQuery(limit)).execute()
        return response.data?.launchesPast
    }

    @GetMapping("/{id}")
    suspend fun getLaunch(@PathVariable id: Int): LaunchDetailsQuery.Launch? {
        val response  = apolloClient.query(LaunchDetailsQuery(id.toString())).execute()
        return response.data?.launch
    }
}