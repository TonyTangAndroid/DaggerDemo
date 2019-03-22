package demo.motif.expose

import com.google.common.truth.Truth

import org.junit.Test

import motif.Scope

class Scratch {


    @Test
    fun with_factory() {
        val rootScope = RootScopeFactoryImpl().create("abc")
        val actual = rootScope.request().execute()
        Truth.assertThat(actual).isEqualTo("abc:success")
    }

    @Test
    fun without_factory() {
        val rootScope = RootScopeImpl { "abc" }
        val actual = rootScope.request().execute()
        Truth.assertThat(actual).isEqualTo("abc:success")
    }


}