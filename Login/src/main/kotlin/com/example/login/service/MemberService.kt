package com.example.login.service

import com.example.login.common.BaseException
import com.example.login.common.BaseResponseCode
import com.example.login.model.Member
import com.example.login.repository.MemberRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class MemberService (private val memberRepository: MemberRepository) {
    fun login(email: String, password: String): ResponseEntity<Any> {
        val member: Member? = memberRepository.findByEmail(email)
        member ?: throw BaseException(BaseResponseCode.USER_NOT_FOUND)

        if(!member.checkPassword(password)){
            throw BaseException(BaseResponseCode.INVALID_PASSWORD)
    }

    return ResponseEntity.ok().body(member)
}
    fun join(email: String, password: String): ResponseEntity<Any>{
        val member:Member? = memberRepository.findByEmail(email)
        member?.let {throw BaseException(BaseResponseCode.DUPLICATE_USER) }
        return ResponseEntity.ok().body(memberRepository.save(Member(email, password)))
    }
}