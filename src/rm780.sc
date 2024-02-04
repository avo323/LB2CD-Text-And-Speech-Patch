;;; Sierra Script 1.0 - (do not remove this comment)
(script# 780)
(include sci.sh)
(use Main)
(use LBRoom)
(use Inset)
(use n958)
(use Sound)
(use View)
(use Obj)

(public
	rm780 0
)

(instance rm780 of LBRoom
	(properties
		picture 780
		style $000a
	)
	
	(method (init)
		(proc958_0 132 795)
		(super init:)
		(wrapMusic
			init: 1 795 1312 (if (== global106 32) 310 else 314) 311
		)
		(gGame handsOff:)
		(gIconBar disable:)
		(gGame setCursor: 996 1)
		(self setScript: runTheCredits)
	)
)

(instance runTheCredits of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 782 0) self)
			)
			(1 (= cycles 2))
			(2
				(DisposeScript 782)
				(= cycles 2)
			)
			(3
				(self setScript: (ScriptID 781 0) self)
			)
			(4 (= cycles 2))
			(5
				(DisposeScript 781)
				(= seconds 2)
			)
			(6 (= cycles 2))
			(7
				(global2 setInset: daggerInset self)
			)
			(8 (= seconds 3))
			(9 (= global4 1))
		)
	)
)

(instance wrapMusic of WrapMusic
	(properties)
	
	(method (init)
		(= wrapSound creditSound)
		(super init: &rest)
	)
)

(instance creditSound of Sound
	(properties)
)

(instance daggerEnd of View
	(properties
		x 88
		y 85
		view 401
		cel 1
	)
	
	(method (doVerb)
		(daggerInset doVerb: &rest)
	)
)

(instance daggerInset of Inset
	(properties
		picture 401
	)
	
	(method (init)
		(super init: &rest)
		(daggerEnd init:)
		(gGame handsOn:)
		(gIconBar enable:)
	)
	
	(method (handleEvent pEvent)
		(gGame handsOff:)
		(pEvent claimed: 1)
		(daggerEnd dispose:)
		(self dispose:)
	)
)
