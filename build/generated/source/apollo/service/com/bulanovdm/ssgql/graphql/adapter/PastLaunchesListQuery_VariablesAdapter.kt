//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.0'.
//
package com.bulanovdm.ssgql.graphql.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.IntAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.bulanovdm.ssgql.graphql.PastLaunchesListQuery
import kotlin.IllegalStateException
import kotlin.Unit

public object PastLaunchesListQuery_VariablesAdapter : Adapter<PastLaunchesListQuery> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      PastLaunchesListQuery = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: PastLaunchesListQuery,
  ): Unit {
    writer.name("limit")
    IntAdapter.toJson(writer, customScalarAdapters, value.limit)
  }
}
