//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.5.0'.
//
package com.bulanovdm.ssgql.graphql

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Query
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import com.bulanovdm.ssgql.graphql.adapter.LaunchDetailsQuery_ResponseAdapter
import com.bulanovdm.ssgql.graphql.adapter.LaunchDetailsQuery_VariablesAdapter
import com.bulanovdm.ssgql.graphql.selections.LaunchDetailsQuerySelections
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

public data class LaunchDetailsQuery(
  public val id: String,
) : Query<LaunchDetailsQuery.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    LaunchDetailsQuery_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = LaunchDetailsQuery_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = com.bulanovdm.ssgql.graphql.type.Query.type
  )
  .selections(selections = LaunchDetailsQuerySelections.__root)
  .build()

  public data class Data(
    public val launch: Launch?,
  ) : Query.Data

  public data class Launch(
    public val id: String?,
    public val mission_name: String?,
    public val details: String?,
    public val links: Links?,
  )

  public data class Links(
    public val flickr_images: List<String?>?,
    public val mission_patch: String?,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "250f92f9084460548a021c2d92ab4a514709305d8dc0c58ca6b0d26b0bcf7a69"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * query launchDetails($id: ID!) {
     *   launch(id: $id) {
     *     id
     *     mission_name
     *     details
     *     links {
     *       flickr_images
     *       mission_patch
     *     }
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "query launchDetails(${'$'}id: ID!) { launch(id: ${'$'}id) { id mission_name details links { flickr_images mission_patch } } }"

    public const val OPERATION_NAME: String = "launchDetails"
  }
}
