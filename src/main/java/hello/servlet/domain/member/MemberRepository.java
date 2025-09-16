package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    // 인스턴스가 많아져도 static인 store와 sequence는 하나만 존재 가능
    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    // 조회는 getInstance로만 가능하다.
    public static MemberRepository getInstance() {
        return instance;
    }

    // 싱글톤 만들 땐 private로 생성자 막기
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // store 자체를 보호하기 위해 ArrayList로 불러오기
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
